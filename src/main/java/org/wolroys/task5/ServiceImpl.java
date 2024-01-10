package org.wolroys.task5;

public class ServiceImpl implements Service{
    @Override

    public String concatString(String str) {
        for (int i = 0; i < 10000; i++){
            str = str.concat("str");
        }

        return str;
    }
}
