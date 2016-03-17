package com.sect.lamda;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintLineMain {

	public static void main(String[] args) throws IOException {
		Runnable ab = ()->{System.out.println("0000");};
		FunctionInterface functionInterface = (int x)->{System.out.println("0000");};
		
		functionInterface.add(2, 2);
		
		Double priceChannel = 1000.89;
		Double ruserPrice = 50.23;
		Double rguidePrice = 152.23;
		Double toProfit = DoubleUtil.subtractionDouble(priceChannel, DoubleUtil.addDouble(ruserPrice, rguidePrice));
		Double butie = DoubleUtil.subtractionDouble(DoubleUtil.addDouble(ruserPrice, rguidePrice), priceChannel);
		
		System.out.println("toProfit:"+toProfit +"	butie:"+butie);
		
		Stream<Path> pstream = Files.list(new File("D:\\").toPath());
		Stream<Path> pstream2 =pstream.filter(predicate->{
			System.out.println(predicate.toAbsolutePath());
			String x = predicate.toString();
			return x.indexOf(",")>0;
		});
		
		List<Path> adlist = pstream2.map(p->{
			return p.getFileName();
		}).collect(Collectors.toList());
		System.out.println(adlist);
	}

}
