package rubic;

import com.rubic.framework.data.DataSet;
import com.rubic.framework.data.MatrixDataSet;
import com.rubic.framework.data.ResultDataSet;
import com.rubic.framework.data.example.Example;
import com.rubic.framework.data.example.MatrixExample;
import com.rubic.framework.execute.java.JavaAlgorithm;
import com.rubic.framework.execute.java.OperationalData;
import com.rubic.framework.util.CallBack;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrew  on 2016/10/9.
 */
public class AlgorithmTest implements JavaAlgorithm{

    public AlgorithmTest() {
    }

    @Override
    public ResultDataSet run(DataSet dataSet, List list, CallBack callBack) {
        List examples = dataSet.getDataSources();
        Iterator var5 = examples.iterator();
        System.out.println("Algorithm:"+this.getClass().getClassLoader());
        System.out.println("Algorithm parents:"+this.getClass().getClassLoader().getParent());
        while(var5.hasNext()) {
            Example example = (Example)var5.next();
            System.out.println(example.getContent());
        }

        return null;
    }

    @Override
    public Object trainingModel(DataSet dataSet, Object o) {
        return null;
    }

    @Override
    public ResultDataSet usingModel(DataSet dataSet, Object o) {
        return null;
    }
}
