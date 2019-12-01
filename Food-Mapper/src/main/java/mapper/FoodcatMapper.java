package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Foodcat;
import pojo.FoodcatExample;

public interface FoodcatMapper {
    int countByExample(FoodcatExample example);

    int deleteByExample(FoodcatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Foodcat record);

    int insertSelective(Foodcat record);

    List<Foodcat> selectByExample(FoodcatExample example);

    Foodcat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Foodcat record, @Param("example") FoodcatExample example);

    int updateByExample(@Param("record") Foodcat record, @Param("example") FoodcatExample example);

    int updateByPrimaryKeySelective(Foodcat record);

    int updateByPrimaryKey(Foodcat record);
}