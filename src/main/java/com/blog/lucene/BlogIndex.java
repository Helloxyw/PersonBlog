package com.blog.lucene;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.blog.entity.Blog;
import com.blog.util.DateUtil;
import com.blog.util.StringUtil;

public class BlogIndex {

	private Directory dir;

	// 获取IndexWriter
	private IndexWriter getWriter() throws IOException {

		// 指定索引存放位置
		dir = FSDirectory.open(Paths.get("/home/xyw/BlogLucene/blog_index"));
		// 创建指定索引语言词汇的分析器
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();

		IndexWriterConfig config = new IndexWriterConfig(analyzer);

		IndexWriter writer = new IndexWriter(dir, config);
		return writer;
	}

	// 添加博客索引
	public void addIndex(Blog blog) throws IOException {
		IndexWriter writer = getWriter();
		Document doc = new Document(); // 创建Document,代表要索引的文档,
		// 向Document文档中添加Field信息,不同类型的信息用不同类型的Field来表示
		doc.add(new StringField("id", String.valueOf(blog.getId()),
				Field.Store.YES));
		doc.add(new TextField("title", blog.getTitle(), Field.Store.YES));
		doc.add(new StringField("releaseDate", DateUtil.formatDate(
				blog.getReleaseDate(), "yyyy-MM-dd"), Field.Store.YES));
		doc.add(new TextField("content", blog.getContent(), Field.Store.YES));
		writer.addDocument(doc);
		writer.close();
	}

	// 删除指定博客索引
	public void deleteIndex(Blog blog) throws Exception {
		IndexWriter writer = getWriter();
		writer.deleteDocuments(new Term("id", String.valueOf(blog.getId())));
		writer.forceMergeDeletes();
		writer.commit();
		writer.close();
	}

	// 更新博客索引
	public void updateIndex(Blog blog) throws Exception {
		IndexWriter writer = getWriter();
		Document doc = new Document();
		doc.add(new StringField("id", String.valueOf(blog.getId()),
				Field.Store.YES));
		doc.add(new TextField("title", blog.getTitle(), Field.Store.YES));
		doc.add(new StringField("releaseDate", DateUtil.formatDate(
				blog.getReleaseDate(), "yyyy-MM-dd"), Field.Store.YES));
		doc.add(new TextField("content", blog.getContent(), Field.Store.YES));
		writer.updateDocument(new Term("id", String.valueOf(blog.getId())), doc);
		writer.close();
	}

	// 查询博客索引信息
	public List<Blog> searchBlog(String q) throws Exception {
		dir = FSDirectory.open(Paths.get("/home/xyw/BlogLucene/blog_index"));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(reader);
		BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();

		QueryParser parserTitle = new QueryParser("title", analyzer);// 查询标题
		Query queryTitle = parserTitle.parse(q);

		QueryParser parserContent = new QueryParser("content", analyzer);// 查询内容
		Query queryContent = parserTitle.parse(q);

		booleanQuery.add(queryTitle, BooleanClause.Occur.SHOULD);
		booleanQuery.add(queryContent, BooleanClause.Occur.SHOULD);

		TopDocs hits = searcher.search(booleanQuery.build(), 100);

		QueryScorer scorer = new QueryScorer(queryTitle);// 使用title分数高的排前面
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);// 得分高的片段
		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter(
				"<b><font color='red'>", "</font></b>");
		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer); // 高亮显示
		highlighter.setTextFragmenter(fragmenter); // 将得分高的片段设置进去

		List<Blog> blogIndexList = new LinkedList<Blog>();// 用来封装查询到的博客

		for (ScoreDoc score : hits.scoreDocs) {
			Document doc = searcher.doc(score.doc);
			Blog blog = new Blog();
			blog.setId(Integer.parseInt(doc.get("id")));
			blog.setReleaseDateStr(doc.get("relaseDate"));
			String title = doc.get("title");
			String content = doc.get("content");
			if (title != null) {
				TokenStream tokenStream = analyzer.tokenStream("title",
						new StringReader(title));
				String hTitle = highlighter.getBestFragment(tokenStream, title);
				if (StringUtil.isEmpty(hTitle)) {
					blog.setTitle(title);
				} else {
					blog.setTitle(hTitle);
				}
			}
			if (content != null) {
				TokenStream tokenStream = analyzer.tokenStream("content",
						new StringReader(content));
				String hContent = highlighter.getBestFragment(tokenStream,
						content);
				if (StringUtil.isEmpty(hContent)) {
					if (content.length() > 100) { // 如果没查到且content内容又大于100的话
						blog.setContent(content.substring(0, 100)); // 截取100个字符
					} else {
						blog.setContent(content);
					}
				} else {
					blog.setContent(hContent);
				}
			}
			blogIndexList.add(blog);
		}

		return blogIndexList;
	}
}
