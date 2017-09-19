package com.effectivejava.chapter20.chapyter16.rectify;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by maskwang on 2017/8/19 0019.
 */
public class InstrumentSet<E> extends ForwoardingSet<E> {
    private int addCount=0;
    public InstrumentSet(Set<E> s){
        super(s);
    }
    @Override
    public boolean add(E e){
        addCount++;
        return super.add(e);
    }
    @Override
    public boolean addAll(Collection<? extends E> c){
        addCount+=c.size();
        return super.addAll(c);
    }
    public int getCount(){
        return addCount;
    }
    public static void main(String[] args) {
        InstrumentSet<String> s= new InstrumentSet<>(new HashSet<>());
        s.addAll(Arrays.asList("snap","Crakle","Pop"));
        System.out.println(s.getCount());
    }

}

class ForwoardingSet<E> implements Set<E>{
    private final Set<E> s;
    public ForwoardingSet(Set<E> s){
        this.s=s;
    }
    public void clear(){
        s.clear();
    }
    public boolean contains(Object o){
        return s.contains(o);
    }
    public boolean isEmpty(){
        return s.isEmpty();
    }
    public int size(){
        return s.size();
    }
    public Iterator<E> iterator(){
        return s.iterator();
    }
    public boolean add(E e){
        return s.add(e);
    }
    public boolean remove(Object e){
        return s.remove(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return s.addAll(c);
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
