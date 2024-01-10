package org.wolroys.task5;

public interface Service {

    @OwnCache
    String concatString(String str);
}
