package com.effectivejava.chapter20.current;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by maskwang on 2017/8/22 0022.
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicReference=new AtomicReference<User>();


    public static void main(String[] args) {
        User user=new User("tom",15);
        atomicReference.set(user);
        User updateUser=new User("mask",18);
        atomicReference.compareAndSet(user,updateUser);
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getOld());
    }

    static class User{
        private String name;
        private int old;
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
