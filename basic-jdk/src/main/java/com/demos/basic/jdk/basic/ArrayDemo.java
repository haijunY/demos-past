package com.demos.basic.jdk.basic;

public class ArrayDemo {

    private void m1(String str){
        str = "bcd";
    }

    private void m2(ArrayDemoDto arrayDemoDto){
        arrayDemoDto.ar = "vvv";
//        arrayDemoDto = new ArrayDemoDto("vvv");
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.m1(str);
        ArrayDemoDto arrayDemoDto= new ArrayDemoDto("ddd");
        arrayDemo.m2(arrayDemoDto);
        System.out.println(str);
        System.out.println(arrayDemoDto);
    }


    public static class ArrayDemoDto{
        private String ar;

        public ArrayDemoDto(String ar) {
            this.ar = ar;
        }

        public String getAr() {
            return ar;
        }

        public void setAr(String ar) {
            this.ar = ar;
        }

        @Override
        public String toString() {
            return "ArrayDemoDto{" +
                    "ar='" + ar + '\'' +
                    '}';
        }
    }

}
