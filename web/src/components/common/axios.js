'use strict';

import axios from 'axios'
import qs from 'qs'
import server from './config'

import NProgress from 'nprogress'
import { withWarn } from 'antd/lib/modal/confirm';


  const baseURL = server.domain;

const AxiosInstance = axios.create({
    baseURL,
    headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
});
const AxiosJSON = axios.create({
    baseURL,
    headers: { 'Content-Type': 'application/json'}
});
//put post patch
AxiosInstance.interceptors.request.use((config) => {
   

   
    if (config.url.indexOf('?') !== -1) {
        config.url += `&t=${new Date().getTime()}`
    } else {
        config.url += `?t=${new Date().getTime()}`
    }
    if(config.headers['Content-Type'] !="application/json"){
        config.transformRequest = [function (data, headers) {
                    return qs.stringify(data, { allowDots: true })
            }]
    }
   
    
    config.paramsSerializer = params => {
        return qs.stringify(params, { arrayFormat: 'repeat' })
    }
    return config
}, error => {
    return Promise.reject(error)
})
//未登录，拦截跳转至登录界面
AxiosInstance.interceptors.response.use((response)=>{


    console.log("%c"+"======请求响应数据=======","color: #0000FF;",response.data);
    const { data } = response;
    // Request.Get_Common('/common/admin/status').then(res=>{
    //         console.log(res.data,'admin/status')
    // })

    return response;
}, error => {
    return Promise.reject(error)
});

//cors 带cookies
AxiosInstance.defaults.withCredentials = true;

const Request = {};



Request.Get_Common = function (url, data = {}) {
    console.log('YIYI%cGet_Common', "color: #0000FF;", url, JSON.stringify(data));
     return AxiosInstance.get( url+"?"+qs.stringify(data, { arrayFormat: 'repeat' }))
};

Request.Get_Rest = function (url, data = {}) {
    console.log('YIYI%cGet_Rest', "color: #0000FF;", url, JSON.stringify(data));
    return AxiosInstance.get(
         url+"/"+data.id
    )
};
Request.Delete_Common = function (url, data = {}) {
    console.log('YIYI%cDelete_Common', "color: #0000FF;", url, JSON.stringify(data));
    return AxiosInstance.delete(
         url+"?"+qs.stringify(data),

    )
};
Request.Delete_Rest = function (url, data = {}) {
    console.log('YIYI%cDelete_Rest', "color: #0000FF;", url, JSON.stringify(data));
    return AxiosInstance.delete(
         url+"/"+data.id
    )
};

Request.Delete_Common = function (url, data = {}) {
    console.log('YIYI%cDelete_Common', "color: #0000FF;", url, JSON.stringify(data));
    return AxiosInstance.delete(
         url+"?"+qs.stringify(data)
    )
};


Request.Put_Common = function (url, data = {}) {
    console.log('YIYI%cPut_Common', "color: #0000FF;", url, JSON.stringify(data));
    return AxiosInstance.put(
         url,data, {
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }
    )
};
Request.Put_JSON = function (url, data = {}) {
    console.log('YIYI%cPut_JSON', "color: #0000FF;", url,data );
    return AxiosInstance.put(
         url,data, {
            headers: {'Content-Type': 'application/json'}
        }
    )
};
Request.Get_JSON = function (url, data = {}) {
    console.log('YIYI%cGet_Common', "color: #0000FF;", url, JSON.stringify(data));
    return AxiosInstance.get(
         url,data, {
            headers: {'Content-Type': 'application/json'}
        }
    )
};

Request.Post_Common = function (url, data = {}) {
    console.log('YIYI%cPost_Common', "color: #0000FF;", url, JSON.stringify(data));
    return AxiosInstance.post(
         url,data, {
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }
    )
};

Request.Post_JSON = function (url, data = {}) {
    console.log('YIYI%cPost_Common', "color: #0000FF;", url,data );
    return AxiosInstance.post(
         url,data, {
            headers: {'Content-Type': 'application/json'}
        }
    )
};
export  default  Request;
// export default {
//     Request,
//     server
// };
