package com.penguins.common.base;

import com.penguins.common.Result;
import com.penguins.utils.CommonUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 抽象的控制类
 */
public abstract class AbstractController {

    /**
     * 更新登录信息
     */
    /*protected void updateSessionUser() {
    	// TODO 使用shiro api 更新登录信息
    	try {
    		// User loginUser = getLoginPortalUser();
    
    		Subject subject = SecurityUtils.getSubject();
    		User loginUser = (User) subject.getPrincipal();
    
    		PropertyUtils.copyProperties(loginUser, userService.getWithTeacherFull(loginUser.getId()));
    		// BeanUtils.copyProperties(loginUser, user);
    	} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
    		throw new SystemException("更新session user错误", e);
    	}
    }*/
    protected HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

//    protected Session getSession() {
//        Subject currentUser = SecurityUtils.getSubject();
//        return currentUser.getSession();
//    }

    protected String readRequest() throws IOException {
        HttpServletRequest request = getHttpServletRequest();

        BufferedReader br = request.getReader();
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    /**
     * 获取当前登录用户
     *
     * @return CommonUser
     */
//    protected CommonUser getLoginCommonUser() {
//        Subject subject = SecurityUtils.getSubject();
//        return (CommonUser) subject.getPrincipal();
//    }
//
//    protected User getLoginPortalUser() {
//        Subject subject = SecurityUtils.getSubject();
//        return (User) subject.getPrincipal();
//    }
//
//    protected AdminUser getLoginAdminUser() {
//        Subject subject = SecurityUtils.getSubject();
//        return (AdminUser) subject.getPrincipal();
//    }
//
//    protected BaseEntity getLoginUser() {
//        Subject subject = SecurityUtils.getSubject();
//        return (BaseEntity) subject.getPrincipal();
//    }
//
//    protected void checkOwner(Integer userId) {
//        if (!getLoginCommonUser().getId().equals(userId)) {
//            throw new BusinessException("当前用户不是数据项的所有者");
//        }
//    }

    /**
     * 获取国际化资源文件
     *
     * @param key  属性文件key
     * @param args 替换占位符的参数
     * @return String String
     */
    protected String getText(String key, Object... args) {
        return CommonUtil.getText(key, args);
    }

    protected Result success() {
        return new Result();
    }

    protected Result success(Object data) {
        return Result.success(data);
    }

    protected Result error(String key, Object... objects) {
        return Result.error(this.getText(key, objects));
    }

}
