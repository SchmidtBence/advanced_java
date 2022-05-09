package iit.miskolc.coverter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Runner {

    List<UnaryOperator<Object[]>> list;
    Object[] results;

    public void addConverter(UnaryOperator<Object[]> function){
        if (Objects.isNull(list)){
            list = new ArrayList<>();
        }
        this.list.add(function);
    }

    public void run(Object[] input) {
        if(list.isEmpty()){
            this.results = null;
            return;
        }
        results = new Object[input.length];
        Object[] localVar = input;

        for(UnaryOperator<Object[]> func : list) {
            try {
                localVar = func.apply(localVar);
            } catch (Exception err) {
                this.results = new Object[] {"Couldn't convert!\nSome problems occurred meanwhile!\n\t" + err.getMessage()};
                return;
            }
        }
        this.results = localVar;
    }
}
