package com.ldh.utils;

import com.ldh.VO.ResultVO;

/**
 * ResultVOUtil
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(Object object, Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
