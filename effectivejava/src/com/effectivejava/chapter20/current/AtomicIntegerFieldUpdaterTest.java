package com.effectivejava.chapter20.current;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by maskwang on 2017/8/22 0022.
 */
public class AtomicIntegerFieldUpdaterTest {
    private static AtomicIntegerFieldUpdater<User> a=AtomicIntegerFieldUpdater.newUpdater(User.class,"old");

    public static void main(String[] args) {
        User connan=new User("conan",10);
        System.out.println(a.getAndIncrement(connan));
        System.out.println(a.get(connan));
    }
    static class User{
        private String name;
        public volatile int old;
        public User(String name,int old){
            this.name=name;
            this.old=old;
        }
        public String getName(){
            return name;
        }
        public int getOld(){
            return old;
        }
    }
}
