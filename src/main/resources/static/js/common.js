/**
 * 判断data是否为空
 * @param {} data
 */
function isNull(data) {
    if (data == undefined || data == null || data == '') {
        return true;
    }
    return false;
}

/**
 显示消息
 */
function showMsg(msg) {
    alert(msg);
}