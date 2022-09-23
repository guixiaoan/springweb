package com.example.guixiaoan.springweb.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/21 09:21
 * @update: 2022/9/21 09:21
 */
public class SplitUtil {

    /**
     *
     * @param allList
     * @param limit 分割每个list得数量
     * @return
     * @param <T>
     */
    public static <T> List<List<T>> getSlitList(List<T> allList,int limit) {
        if (CollectionUtils.isEmpty(allList)) {
            return new ArrayList<List<T>>() ;
        }

        List<List<T>> desList = new ArrayList<List<T>>() ;
        long total = allList.size() ;
        long times = total / limit ;
        long remains = total % limit ;
        times = remains == 0 ? times : times +1 ;

        for (int i=0 ;i < times ; i++ ) {
           List<T> tempList =  allList.stream().skip(i*limit).limit(limit).collect(Collectors.toList()) ;
           desList.add(tempList) ;
        }

        return desList ;
    }
}
