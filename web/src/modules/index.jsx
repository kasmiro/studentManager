import React, { Component } from 'react';
import { Button, Form, Input, Popconfirm, Row, Table, Select, Space } from "antd";
import { inject, observer } from "mobx-react";
import Student from './student'

@inject('Stores')
@observer
class Index extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    render() {
        return (
            <div className="contentBg">
                <div className='modules' style={{}}>
                    <Space align="baseline">
                        <div className="infomation" style={{ fontSize: '20px' }}>学生管理 </div>
                    </Space>
                    <Student />
                </div>
            </div>

        );
    }
}

export default Index;