package com.nitin.quickstart.spark;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkApp {
	
	private static final Pattern SPACE = Pattern.compile(" ");
	
    public static void main( String[] args ) {
        SparkConf sparkConf = new SparkConf()
        		.setMaster("local").setAppName("SimpleSparkApp");
        
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        
        JavaRDD<String> lines = javaSparkContext.textFile("D:\\CODE\\quickstart\\quickstart-parent\\quickstart-spark\\src\\main\\java\\com\\nitin\\quickstart\\spark\\SparkApp.java");

        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)).iterator());

        JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));

        JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1 + i2);

        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<?,?> tuple : output) {
          System.out.println(tuple._1() + ": " + tuple._2());
        }
        
        javaSparkContext.close();
    }
}
