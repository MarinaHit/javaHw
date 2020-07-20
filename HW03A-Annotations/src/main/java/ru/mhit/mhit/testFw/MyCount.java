package ru.mhit.mhit.testFw;

public class MyCount {
        private int count_plus ;
        private int count_minus;
        private int count_all;

        public MyCount() {
            this.count_plus = 0;
            this.count_minus = 0;
            this.count_all = 0;
        }
        public int getCount_plus() {        return count_plus;    }
        public void setCount_plus(int count_plus) {        this.count_plus= count_plus;    }
        public void addCount_plus(){  this.count_plus++;}

        public int getCount_minus() {        return count_minus;    }
        public void setCount_minus(int count_minus) {        this.count_minus = count_minus;    }
        public void addCount_minus(){    this.count_minus++;    }

        public int getCount_all() {        return count_all;    }
        public void setCount_all(int count_all) {        this.count_all = count_all;    }
        public void addCount_all(){  this.count_all++; }

        public void printCount(){
            System.out.print("Test plus: " + this.count_plus);
            System.out.print(" Test minus: " + this.count_minus);
            System.out.print(" Test all: " + this.count_all);
        }
}
