package edu.hanu.tut10.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Constant {
    public static final ExecutorService executor= Executors.newFixedThreadPool(4);
}
