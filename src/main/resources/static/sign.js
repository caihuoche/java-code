


function getSign(params, kAppKey, kAppSecret) {
    if (typeof params == "string") {
        return paramsStrSort(params);
    } else if (typeof params == "object") {
        var arr = [];
        for (var i in params) {
            arr.push((i + "=" + params[i]));
        }
        return paramsStrSort(arr.join(("&")));
    }
}

function paramsStrSort(paramsStr) {
    var url = paramsStr + "&appKey=" + kAppKey;
    var urlStr = url.split("&").sort().join("&");
    var newUrl = urlStr + '&key=' + kAppSecret;
    return md5(newUrl);
}