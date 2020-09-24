import { observable, action, toJS, values } from 'mobx';
import axios from "../components/common/axios";
import { message } from "antd";
import Axios from "../components/common/axios";
import React from "react";
import { hashHistory } from 'react-router'
class CommunityStore {
    //学号
    @observable s_id=''
    //姓名
    @observable s_name=''
    //专业
    @observable major=''
    //班级
    @observable class_id=''
    //教师编号
    @observable t_id=''
    //教师编号
    @observable t_name=''
    //学生总数
    @observable studentTotal=0
    //教师总数
    @observable teacherTotal=0
    //每页条目
    @observable pageSize=5
    //当前页数
    @observable studentCurrent=1
    //当前页数
    @observable teacherCurrent=1
    //学生数据
    @observable studentData=[];
    //学生数据
    @observable teacherData=[];
    @action handleGetStudent = () => {
        Axios.Get_Common("", {
            s_name:this.s_name,
            s_id:this.s_id,
            major:this.major,
            class_id:this.class_id,
        }).then(res => {
            if (res.data.status.code === 1) {
            }
        })
    }
    @action handleGetTeacher = () => {
        Axios.Get_Common("", {
            t_id:this.t_id,
            t_name:this.t_name,
        }).then(res => {
            if (res.data.status.code === 1) {
            }
        })
    }
}
export default new CommunityStore();
