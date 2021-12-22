package com.chinafree.auth.service.impl;

import com.chinafree.auth.exception.BusinessException;
import com.chinafree.auth.model.enumeration.LoginType;
import com.chinafree.auth.model.po.LoginUser;
import com.chinafree.auth.model.result.LoginResult;
import com.chinafree.auth.service.LoginUserService;
import com.chinafree.auth.service.NormalLoginService;

import com.chinafree.common.utils.RegexUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class NormalLoginServiceImpl implements NormalLoginService {

    @Autowired
    private LoginUserService loginUserService;

    public LoginResult login(String loginMail, String password) {
        LoginUser loginUser;
        String loginTimes = "0";
//        log.debug("用户登录");
        if (StringUtils.isEmpty(password)) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "密码格式不正确");
        }
        //判断loginMail是邮箱
        if (RegexUtils.checkMail(loginMail)) {
            //根据邮箱获取用户
            loginUser = loginUserService.getLoginUserByLoginMail(loginMail);
        } else if (RegexUtils.checkMobile(loginMail)) {
            //根据手机号获取用户
            loginUser = loginUserService.getLoginUserByLoginMobile(loginMail);
        } else {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "邮箱或手机格式不正确");
        }

        if (loginUser == null) {
            //用户不存在
            //throw new NotFindLoginUserException();
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"用户不存在！");
        }

            //redis 记录错误次数
//        String redisComponents = redisComponent.get(LOGIN_TIMES_PREFIX + loginMail);//从redis获取输入错误密码的记录
//        if (StringUtils.isEmpty(redisComponents)) {
//            if(StringUtils.isEmpty(loginUser.getPassword())){
//                throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"您未设置密码!!");
//            }
//            //错误密码记录不存在,验证用户密码是否正确
//            if (!loginUser.getPassword().equals(MD5Utils.hash(password))) {
//                //密码错误,向redis插入错误密码的记录,提示密码错误
//                redisComponent.set(LOGIN_TIMES_PREFIX + loginMail, loginTimes, PASSWORD_EFFECTIVE_TIME);
//                throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "密码错误");
//            }
//        } else {
//            //错误密码记录存在,就获取错误次数
//            Integer cLoginTime = Integer.valueOf(redisComponent.get(LOGIN_TIMES_PREFIX + loginMail));
//            if (cLoginTime < 5) {
//                //错误次数不到5次,可以继续验证用户密码是否正确
//                if (!loginUser.getPassword().equals(MD5Utils.hash(password))) {
//                    //密码错误,错误次数+1并存入redis,提示密码错误
//                    redisComponent.set(LOGIN_TIMES_PREFIX + loginMail, String.valueOf(cLoginTime + 1), PASSWORD_EFFECTIVE_TIME);
//                    throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "密码错误");
//                }
//            } else {
//                //错误次数达到5次,冻结用户,提示：输入密码错误超过5次请稍后重试
//                //String loginId = this.loginUserService.getPrimaryKey();
//                //this.loginUserStatusService.updateLoginUserStatus(loginId, LoginUserConstant.LoginUserStatusType.MORE_TIMES_STSTUS);
//                throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "输入密码错误超过5次，请稍后重试");
//            }
//        }
//        /*密码正确,就登录*/
//        //this.loginUserStatusService.updateLoginUserStatus(loginUser.getId(), LoginUserConstant.LoginUserStatusType.NORMAL_STATUS);
//        LoginRef loginRef = loginUser.getLoginRef();
//        if (loginRef == null) {
//            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "loginRef为空");
//        }
//
//        Map<String,String> map = new HashMap<>();
//        map.put("loginId",loginUser.getId());
//        map.put("userId",loginRef.getUserId());
//        LoginResult result = new LoginResult();
//        result.setLoginId(loginUser.getId());
//        result.setLoginUserType(loginUser.getLoginUserType());
//        result.setUserId(loginRef.getUserId());
//        //通过LoginId查询第三方列表
//        String loginId = loginUser.getId();
//        List<ThirdPartAccount> thirdPartAccountList = this.thirdPartAccountDao.selectThirdPartAccountByLoginId(loginId);
//        //填充List<ThirdPartAccountResult>信息
//        List<ThirdPartAccountResult> thirdPartAccountResultList = new ArrayList<>();
//        for (ThirdPartAccount thirdPartAccount :thirdPartAccountList){
//            ThirdPartAccountResult thirdPartAccountResults = new ThirdPartAccountResult();
//            BeanUtils.copyProperties(thirdPartAccount,thirdPartAccountResults);
//            thirdPartAccountResultList.add(thirdPartAccountResults);
//        }
//        //将第三方列表信息塞入Result中
//        result.setThirdPartAccountResults(thirdPartAccountResultList);
//        result.setToken(loginUserService.getPrimaryKey());
//        //将loginId和userId存入redis中
//        redisComponent.set(TOKEN +result.getToken(),map,TOKEN_EFFECTIVE_TIME);
//        return result;


            return LoginResult.builder()
                    .loginId(loginUser.getUserId())
                    .loginUserType(LoginType.LoginUserType.NORMAL.value)
                    .build();
    }






}