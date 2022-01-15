package com.mymapreducecode.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MyWordCountReducer extends Reducer<Text, IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        int count = 0;
        for(IntWritable value:values){
            int intvalue = value.get();
            count = count + intvalue;
        }
        context.write(key,new IntWritable(count));
    }
}
