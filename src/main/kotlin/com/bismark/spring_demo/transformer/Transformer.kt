package com.bismark.spring_demo.transformer

interface Transformer<A,B> {
    fun transform(source: A): B
}