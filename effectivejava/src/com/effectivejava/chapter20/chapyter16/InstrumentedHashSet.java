package com.effectivejava.chapter20.chapyter16;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by maskwang on 2017/8/19 0019.
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount=0;
    public InstrumentedHashSet(){

    }
    public InstrumentedHashSet(int initCap,float loadFactor){
        super(initCap,loadFactor);
    }
    @Override
    public boolean add(E e){
        addCount++;
        return super.add(e);
    }
//    @Override
//    public  boolean addAll(Collection<? extends E> c){
//        addCount+=c.size();
//        return super.addAll(c);
//    }
    public int getAddCount(){
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> s= new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("snap","Crakle","Pop"));
        System.out.println(s.getAddCount());
    }

}
