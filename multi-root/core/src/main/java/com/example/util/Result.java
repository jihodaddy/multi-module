package com.example.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    // 성공
    public final static String STATUS_SUCCESS = "S";
    public final static String STATUS_SUCCESS_MESSAGE = "정상 처리되었습니다.";

    // 오류
    public final static String STATUS_ERROR = "E";
    public final static String STATUS_ERROR_DEFAULT_DETAIL_CODE = "E9999";
    public final static String STATUS_ERROR_MESSAGE = "처리 도중 오류가 발생 되었습니다.";

    // 경고
    public final static String STATUS_WARNING = "W";
    public final static String STATUS_WARNING_MESSAGE = "처리 도중 경고가 발생 되었습니다.";

    // 기본(Map 타입) 웹스퀘어 view
    public final static String VIEW_DEFAULT = "wqView";

    // 결과값에 대한 메세지 key명
    public final static String MESSAGE_KEY = "rsMsg";

    // viewType이 VIEW_STRING 일 경우 참조하는 key
    public final static String RESULT_KEY_DEFAULT = "result";

    private Map<String, Object> resultMap = new HashMap<>();

    // setter 오버로딩
    public void setData(String id, String data) {
        resultMap.put(id, data);
    }
    public void setData(String id, Map data) {
        resultMap.put(id, data);
    }
    public void setData(String id, List data) {
        resultMap.put(id, data);
    }

    // getter
    public Map<String, Object> getResult() {
        if (resultMap.get(MESSAGE_KEY) == null) {
            setMsg("");
        }
        return resultMap;
    }

    public void setMsg(String status) {
        String msg = "";
        if (status == STATUS_ERROR) {
            msg = STATUS_ERROR_MESSAGE;
        } else if (status == STATUS_SUCCESS) {
            msg = STATUS_SUCCESS_MESSAGE;
        } else if (status == STATUS_WARNING) {
            msg = STATUS_WARNING_MESSAGE;
        }
        setMsg(status, msg);
    }

    public void setMsg(String status, String message) {
        Map<String, Object> result = new HashMap<>();

        if (status.equals(STATUS_SUCCESS)) {
            result.put("statusCode", STATUS_SUCCESS);
            result.put("message", getDefaultStatusMessage(message, STATUS_SUCCESS_MESSAGE));
        } else if (status.equals(STATUS_WARNING)) {
            result.put("statusCode", STATUS_WARNING);
            result.put("message", getDefaultStatusMessage(message, STATUS_WARNING_MESSAGE));
        } else if (status.equals(STATUS_ERROR)) {
            result.put("statusCode", STATUS_ERROR);
            result.put("message", getDefaultStatusMessage(message, STATUS_ERROR_MESSAGE));
        }
        resultMap.put(MESSAGE_KEY, result);
    }

    public void setStatus(String status) {
        Map<String, Object> result = new HashMap<>();

        if (status.equals(STATUS_SUCCESS)) {
            result.put("statusCode", STATUS_SUCCESS);
        } else if (status.equals(STATUS_WARNING)) {
            result.put("statusCode", STATUS_WARNING);
        } else if (status.equals(STATUS_ERROR)) {
            result.put("statusCode", STATUS_ERROR);
        }
        result.put(MESSAGE_KEY, result);
    }

    public void setStatusMsg(String status, String statusMsg) {
        Map<String, Object> result = new HashMap<>();

        if (status.equals(STATUS_SUCCESS)) {
            result.put("statusCode", STATUS_SUCCESS);
            result.put("statusMsg", getDefaultStatusMessage(statusMsg, STATUS_SUCCESS_MESSAGE));
        } else if (status.equals(STATUS_WARNING)) {
            result.put("statusCode", STATUS_WARNING);
            result.put("statusMsg", getDefaultStatusMessage(statusMsg, STATUS_WARNING_MESSAGE));
        } else if (status.equals(STATUS_ERROR)) {
            result.put("statusCode", STATUS_ERROR);
            result.put("statusMsg", getDefaultStatusMessage(statusMsg, STATUS_ERROR_MESSAGE));
        }

        resultMap.put(MESSAGE_KEY, result);
    }

    public void setFailMsg(Exception ex, String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("statusCode", STATUS_ERROR);
        result.put("message", getDefaultStatusMessage(message, STATUS_ERROR_MESSAGE));
        resultMap.put(MESSAGE_KEY, result);
        ex.printStackTrace();
    }

    public String getDefaultStatusMessage(String message, String defMessage) {
        if (message == null) {
            return defMessage;
        }
        return message;
    }
}
