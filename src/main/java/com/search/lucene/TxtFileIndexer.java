package com.search.lucene;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * This class demonstrate the process of creating index with Lucene for text
 * files
 */
public class TxtFileIndexer {
	public static void main(String[] args) throws Exception {
		// indexDir is the directory that hosts Lucene's index files
		File indexDir = new File("D:\\dev\\gk\\workspace\\jdesign\\data");
		// dataDir is the directory that hosts the text files that to be indexed

		Directory dir = FSDirectory.open(Paths.get(indexDir.getPath()));
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

		iwc.setOpenMode(OpenMode.CREATE);

		// Optional: for better indexing performance, if you
		// are indexing many documents, increase the RAM
		// buffer. But if you do this, increase the max heap
		// size to the JVM (eg add -Xmx512m or -Xmx1g):
		//
		// iwc.setRAMBufferSizeMB(256.0);
		IndexWriter writer = new IndexWriter(dir, iwc);
		for(int x=0;x<1000000;x++){
			Document doc = new Document();
			TextField tf = new TextField("name", UUID.randomUUID().toString(), Field.Store.YES);
			doc.add(tf);
			writer.addDocument(doc);
			
			System.out.println(tf.toString());
		}
		writer.forceMerge(4);
		writer.close();
	}
}