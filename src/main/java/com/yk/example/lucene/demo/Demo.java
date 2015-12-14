//package com.yk.example.lucene.demo;
//
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.standard.StandardAnalyzer;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
//import org.apache.lucene.document.TextField;
//import org.apache.lucene.index.DirectoryReader;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.queryparser.classic.QueryParser;
//import org.apache.lucene.search.IndexSearcher;
//import org.apache.lucene.search.Query;
//import org.apache.lucene.search.ScoreDoc;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.RAMDirectory;
//import org.apache.lucene.util.Version;
//
//
///**
// * Created by yk on 15/12/4.
// */
//public class Demo {
//
//    public void test() throws Exception {
//        Analyzer analyzer = new StandardAnalyzer();
//        //索引存到内存
//        Directory directory = new RAMDirectory();
//        //索引存到磁盘中
////      Directory directory = FSDirectory.getDirectory("/Users/yk",true);
//        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST,analyzer);
//        IndexWriter indexWriter = new IndexWriter(directory,config);
//        Document document = new Document();
//        String text = "This is the text to be indexed.";
//        document.add(new Field("fieldname", text, TextField.TYPE_STORED));
//        indexWriter.addDocument(document);
//        indexWriter.close();
//
//        DirectoryReader reader = DirectoryReader.open(directory);
//        IndexSearcher indexSearcher = new IndexSearcher(reader);
//        QueryParser queryParser = new QueryParser("fieldname", analyzer);
//        Query query = queryParser.parse("text");
//        ScoreDoc[] hits = indexSearcher.search(query, null, 1000).scoreDocs;
////        Assert.assertEquals(1, hits.length);
//        System.out.println("命中的数组的长度" + hits.length);
//
//        for (int i = 0; i < hits.length; i++) {
//            Document hitDoc = indexSearcher.doc(hits[i].doc);
////            Assert.assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
//            System.out.println(hitDoc.get("fieldname"));
//        }
//
//        reader.close();
//
//    }
////
////    public static void main(String[] args) throws Exception{
////        Demo demo = new Demo();
////        demo.test();
////    }
//
//}
