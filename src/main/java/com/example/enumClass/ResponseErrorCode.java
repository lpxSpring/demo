package com.example.enumClass;

/**
 * @author 18124550
 * @date 2019/8/2
 */
public enum ResponseErrorCode {
    CREATE_TASK_SUCCESS("000","新增训练任务成功!") ,
    FIND_TASK_SUCCESS("000","查询训练任务详情成功！"),
    INVALID_PARAM("001","参数不合法!") ,
    NOTFOUND_TEMPLATE("002","未找到对应的模板，请联系机器学习平台管理员。"),
    NOTFOUND_TRAIN_ENV_CONF("003","未找到对应的任务配置信息，请联系机器学习平台管理员。"),
    NOTFOUND_SYSTEM_INFO("004", "未找到对应的系统信息，请联系机器学习平台管理员。"),
    CREATE_TASK_ERROR("005", "新增任务异常:"),
    DATASET_IMPORT_ERROR("006", "导入数据集异常:"),
    EXIST_TASK_ID("007", "该训练任务已经存在！请更换任务ID。"),
    NOT_EXIST_TASK_ID("008","对应的训练任务不存在!"),

    TASK_STOPPING("009","发送停止训练任务请求成功，任务停止中..."),
    TASK_STOP_FAILED("010","发送停止训练任务请求失败！"),

    PREVIOUS_TASK_EXEC_NOT_RESULT("011","未找到前一次训练任务输出的模型！");

    private String code;
    private String msg;

    // 默认私有构造
    ResponseErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ResponseErrorCode{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + '}';
    }

    public static void main(String[] args) {
        System.out.println(ResponseErrorCode.CREATE_TASK_ERROR.getMsg());

        System.out.println(ResponseErrorCode.CREATE_TASK_ERROR.compareTo(ResponseErrorCode.NOT_EXIST_TASK_ID));

    }
}
