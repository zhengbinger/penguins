package com.penguins.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 通用处理创建人、创建时间、更新人、更新时间  Mybatis 拦截器
 *
 * @author 郑冰
 * @date 2022/4/19 12:28
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Slf4j
@Component
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
})
public class MybatisCommonInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
//
//    public static final Integer INDEX_ZERO = 0;
//    public static final Integer INDEX_ONE = 1;
//    public static final String CREATE_TIME_COLUMN = "create_time";
//    public static final String CREATE_TIME_FEILD = "createTime";
//    public static final String CREATE_BY_FEILD = "createBy";
//    public static final String CREATE_BY_COLUMN = "create_by";
//    public static final String UPDATE_BY_COLUMN = "update_by";
//    public static final String UPDATE_BY_FEILD = "updateBy";
//    public static final String UPDATE_TIME_FEILD = "updateTime";
//    public static final String UPDATE_TIME_COLUMN = "update_time";
//
//    public static final String DEL_FLAG_COLUMN = "del_flag";
//    public static final String DEL_FLAG_FEILD = "delFlag";
//    public static final String DEL_FLAG_DEFAULT = "0";
//    public static final String TYPE_STRING = "java.lang.String";
//    public static final String TYPE_DATE = "java.util.Date";
//    public static final String TYPE_INTEGER = "java.lang.Integer";
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        log.info("====================>>>>>  MybatisPlus 处理通用字段，新增和修改");
//        // 获取参数
//        Object[] queryArgs = invocation.getArgs();
//        MappedStatement mappedStatement = (MappedStatement) queryArgs[INDEX_ZERO];
//        Object object = queryArgs[INDEX_ONE];
//
//        // 获取sql
//        BoundSql boundSql = mappedStatement.getBoundSql(object);
//        String sql = boundSql.getSql();
//
//        // 获取sql参数列表
//        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
//        List<String> propertyList = parameterMappings.stream().map(ParameterMapping::getProperty).collect(Collectors.toList());
//
//        // 根据sql类型对应不同操作
//        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
//        if (SqlCommandType.INSERT.equals(sqlCommandType)) {
//            // 插入操作时，自动插入
//            autoFieldInsertField(object);
//            // 拼接预编译sql
//            sql = appendInsertSql(sql);
//            // 添加参数
//            autoFieldInsertParams(mappedStatement, parameterMappings, propertyList);
//        }
//        if (SqlCommandType.UPDATE.equals(sqlCommandType)) {
//            // 更新操作时，自动插入
//            autoFieldUpdateField(object);
//            // 拼接预编译sql
//            sql = appendUpdateSql(sql);
//            // 添加参数
//            autoFieldUpdateParams(mappedStatement, parameterMappings, propertyList);
//        }
//        if (SqlCommandType.SELECT.equals(sqlCommandType)) {
//            sql = appendQuerySql(sql);
//            // 重新new一个查询语句对像
//            BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), sql, parameterMappings, boundSql.getParameterObject());
//            // 把新的查询放到statement里
//            MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));
//            queryArgs[INDEX_ZERO] = newMs;
//        }
//        return invocation.proceed();
//    }
//
//    private String appendQuerySql(String sql) throws JSQLParserException, ParseException {
//        Statement statement = CCJSqlParserUtil.parse(sql);
//        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
//        List<String> tableList = tablesNamesFinder.getTableList(statement);
////        if (!sql.substring(sql.indexOf("from")).contains("del_flag")) {
////            if (sql.contains("where")) {
////                sql = new StringBuilder().append(sql, 0, sql.indexOf("where") + 5).append("del_flag = 0 and").append(sql.substring(sql.indexOf("where") + 5)).toString();
////            } else {
//////                new StringBuffer().append(sql).append()
////            }
////    }
//        return sql;
//    }
//
//    private void autoFieldUpdateParams(MappedStatement mappedStatement, List<ParameterMapping> parameterMappings, List<String> propertyList) {
//        if (!propertyList.contains(UPDATE_TIME_FEILD)) {
//            parameterMappings.add(0, newParameterMapping(mappedStatement.getConfiguration(), UPDATE_TIME_FEILD, Date.class));
//        }
//        if (!propertyList.contains(UPDATE_BY_FEILD)) {
//            parameterMappings.add(0, newParameterMapping(mappedStatement.getConfiguration(), UPDATE_BY_FEILD, String.class));
//        }
//    }
//
//    private String appendUpdateSql(String sql) {
//        if (!sql.contains(UPDATE_TIME_COLUMN)) {
//            sql = orgUpdateSql(sql, UPDATE_TIME_COLUMN);
//        }
//        if (!sql.contains(UPDATE_BY_COLUMN)) {
//            sql = orgUpdateSql(sql, UPDATE_BY_COLUMN);
//        }
//        return sql;
//    }
//
//    private void autoFieldUpdateField(Object object) throws NoSuchFieldException, IllegalAccessException {
//        setFieldValue(object, UPDATE_BY_FEILD);
//        setFieldValue(object, UPDATE_TIME_FEILD);
//    }
//
//    private void autoFieldInsertParams(MappedStatement mappedStatement, List<ParameterMapping> parameterMappings, List<String> propertyList) {
//        if (!propertyList.contains(CREATE_TIME_FEILD)) {
//            parameterMappings.add(newParameterMapping(mappedStatement.getConfiguration(), CREATE_TIME_FEILD, Date.class));
//        }
//        if (!propertyList.contains(CREATE_BY_FEILD)) {
//            parameterMappings.add(newParameterMapping(mappedStatement.getConfiguration(), CREATE_BY_FEILD, String.class));
//        }
////        if (!propertyList.contains(DEL_FLAG_FEILD)) {
////            parameterMappings.add(newParameterMapping(mappedStatement.getConfiguration(), DEL_FLAG_FEILD, Integer.class));
////        }
//    }
//
//    private String appendInsertSql(String sql) {
//        if (!sql.contains(CREATE_TIME_COLUMN)) {
//            sql = orgSql(sql, CREATE_TIME_COLUMN);
//        }
//        if (!sql.contains(CREATE_BY_COLUMN)) {
//            sql = orgSql(sql, CREATE_BY_COLUMN);
//        }
////        if (!sql.contains(DEL_FLAG_COLUMN)) {
////            sql = orgSql(sql, DEL_FLAG_COLUMN);
////        }
//        return sql;
//    }
//
//    private void autoFieldInsertField(Object object) throws IllegalAccessException, NoSuchFieldException {
//        setFieldValue(object, CREATE_TIME_FEILD);
//        setFieldValue(object, CREATE_BY_FEILD);
//        setFieldValue(object, UPDATE_TIME_FEILD);
//        setFieldValue(object, UPDATE_BY_FEILD);
//    }
//
//    private ParameterMapping newParameterMapping(Configuration configuration, String property, Class<?> javaType) {
//        return new ParameterMapping.Builder(configuration, property, javaType).build();
//    }
//
//    private void setFieldValue(Object object, String filedName) throws IllegalAccessException, NoSuchFieldException {
//
//        List<Field> fields = new ArrayList<>();
//        Field[] declaredFields = object.getClass().getDeclaredFields();
//        Field[] superFields = object.getClass().getSuperclass().getDeclaredFields();
//        fields.addAll(Arrays.asList(declaredFields));
//        fields.addAll(Arrays.asList(superFields));
//
//        Optional<Field> op = fields.stream().filter(s -> s.getName().equals(filedName)).findFirst();
//        op.ifPresent(field -> {
//            field.setAccessible(true);
//            try {
//                Object createValue = field.get(object);
//                if (!Objects.isNull(createValue)) {
//                    return;
//                }
//                //  获取字段类型，根据字段类型赋值
//                String typeName = field.getType().getName();
//                if (TYPE_DATE.equals(typeName)) {
//                    field.set(object, new Date());
//                }
//                if (TYPE_STRING.equals(typeName)) {
//                    field.set(object, "system");
//                }
//                if (TYPE_INTEGER.equals(typeName)) {
//                    field.set(object, 0);
//                }
//            } catch (IllegalAccessException e) {
//                log.error("参数值访问异常", e);
//            }
//        });
//    }
//
//    private String orgUpdateSql(String sql, String param) {
//        String newSql = new StringBuffer().append(sql, 0, sql.indexOf("SET") + 3)
//                .append(" ")
//                .append(param).append("=?, ")
//                .append(sql.substring(sql.indexOf("SET") + 3)).toString();
//
//        return newSql;
//    }
//
//    private String orgSql(String sql, String param) {
//        StringBuffer sb = new StringBuffer();
//        sb.append(sql, 0, sql.indexOf(")"))
//                .append(",").append(param)
//                .append(sql, sql.indexOf(")"), sql.lastIndexOf(")")).append(",?)");
//        return sb.toString();
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        return Plugin.wrap(target, this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }
//
//    private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
//        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
//        builder.resource(ms.getResource());
//        builder.fetchSize(ms.getFetchSize());
//        builder.statementType(ms.getStatementType());
//        builder.keyGenerator(ms.getKeyGenerator());
//        if (ms.getKeyProperties() != null && ms.getKeyProperties().length > 0) {
//            builder.keyProperty(ms.getKeyProperties()[0]);
//        }
//        builder.timeout(ms.getTimeout());
//        builder.parameterMap(ms.getParameterMap());
//        builder.resultMaps(ms.getResultMaps());
//        builder.resultSetType(ms.getResultSetType());
//        builder.cache(ms.getCache());
//        builder.flushCacheRequired(ms.isFlushCacheRequired());
//        builder.useCache(ms.isUseCache());
//        return builder.build();
//    }
//
//    public class BoundSqlSqlSource implements SqlSource {
//        private BoundSql boundSql;
//
//        public BoundSqlSqlSource(BoundSql boundSql) {
//            this.boundSql = boundSql;
//        }
//
//        @Override
//        public BoundSql getBoundSql(Object parameterObject) {
//            return this.boundSql;
//        }
//    }
}