package JavaCore;

public class Variables {
        public int a = getSum();
        public int b = getSum() - a;
        public int c = getSum() - a - b;

        public int getSum()
        {
            return a + b + c;
        }
    }
