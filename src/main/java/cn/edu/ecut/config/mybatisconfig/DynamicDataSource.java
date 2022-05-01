package cn.edu.ecut.config.mybatisconfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;



public class DynamicDataSource extends AbstractRoutingDataSource
{
    private static ThreadLocal<DataSourceType> dsType=new ThreadLocal<DataSourceType>()
    {
        @Override
        protected DataSourceType initialValue() {
            return DataSourceType.MANAGE;
        }
    };

    public static void setDsType(DataSourceType type)
    {
        dsType.set(type);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dsType.get();
    }
}
