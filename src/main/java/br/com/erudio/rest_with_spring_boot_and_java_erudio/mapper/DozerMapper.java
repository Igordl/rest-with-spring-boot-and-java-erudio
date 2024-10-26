package br.com.erudio.rest_with_spring_boot_and_java_erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D map(O source, Class<D> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    public static <O, D> List<D> map(List<O> source, Class<D> destinationClass) {
        List<D> destination = new ArrayList<D>();
        for (O destinationObj : source) {
            destination.add(map(destinationObj, destinationClass));
        }
        return destination;
    }

}
