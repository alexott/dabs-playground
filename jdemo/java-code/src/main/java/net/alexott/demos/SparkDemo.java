package net.alexott.demos;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class SparkDemo {
    public static void main(String[] args) {
        System.out.println("Creating Spark Session!");
        SparkSession spark = SparkSession.builder()
                .appName("SparkDemo")
                .getOrCreate();
        System.out.println("Going to read data!");
        Dataset<Row> df = spark.read().table("samples.nyctaxi.trips");
        df.show(10, false);
    }
}
