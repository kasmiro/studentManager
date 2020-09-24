import React, { Component } from 'react';
import { Button, Form, Input, Popconfirm, Row, Table, Select } from "antd";
import { inject, observer } from "mobx-react";
import FolderButtonSection from "../components/folderButtonSection/folderButtonSection";
import Stores from '../store/Stores';


@inject('Stores')
@observer
class Student extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    formRef = React.createRef();
    componentWillUnmount() {
    }
    componentDidMount() {
        // this.props.Stores.handleGetAllCommunity();
        this.props.Stores.handleGetStudent('all');
    }

    //处理筛选数据
    handleSearch = (e) => {
        this.props.Stores.handleGetStudent();

    };

    //重置按钮
    handleReset = () => {
        this.props.Stores.s_name = '';
        this.props.Stores.s_id = '';
        this.props.Stores.major = '';
        this.props.Stores.class_id = '';
        this.props.Stores.studentTotal = 0;
        this.props.Stores.studentCurrent = 1;
        this.formRef.current.resetFields();
        this.props.Stores.handleGetStudent();

    };

    handlePageNumber = (current) => {
        // console.log(current);
        // this.props.Stores.memberPageNumber = current;
        // this.props.Stores.handleGetStudent();
    };

    //新增/编辑框改变
    changeShow = (type, show, record) => {
        switch (type) {
            case 'edit':
                // hashHistory.push(`/service/edit/${record.id}`);
                Stores.memberEditRecord = {};
                Stores.memberEditRecord.id = record.id;
                Stores.memberEditRecord.name = record.name;
                // Stores.memberEditRecord.password = Crypto.Decrypt(record.password);
                Stores.memberEditRecord.password = '';
                Stores.memberEditRecord.phone = record.phone;
                Stores.memberEditRecord.email = record.email;
                console.log(Stores.memberEditRecord)
                Stores.memberEdit = true;
                break;
            case 'add':
                Stores.memberModal = true;
                break;
        }
        // console.log('edit', this.props.Stores.show.editShow)
    };

    render() {
        let store = this.props.Stores;
        const columns = [
            {
                title: '序号',
                key: 'index',
                align: "center",
                //序号自增
                render: (text, record, index) => `${(current - 1) * pageSize + index + 1}`
            },
            // {
            //     title: '社区',
            //     dataIndex: 'communityName',
            //     key: 'communityName',
            //     align: "center",
            // },
            // {

            //     title: '角色',
            //     dataIndex: 'role',
            //     key: 'role',
            //     align: "center",
            //     render: (text, record, index) => `${record.role === "admin" ? `管理员` : `网格员`}`
            // },
            {
                title: '学号',
                dataIndex: 's_id',
                key: 's_id',
                align: "center",
            },
            {
                title: '姓名',
                dataIndex: 's_name',
                key: 's_name',
                align: "center",
            },
            {
                title: '专业',
                dataIndex: 'major',
                key: 'major',
                align: "center",
            },
            {
                title: '班级',
                dataIndex: 'class_id',
                key: 'class_id',
                align: "center",
            },
            {
                title: '操作',
                align: "center",
                key: 'action',
                render: (text, record, index) => (
                    <span>
                        <Button
                            size="small"
                            type="primary"
                            style={{ marginRight: "10px" }}
                            // onClick={() => { this.changeShow('edit', true, record) }}
                        >
                            编辑
                        </Button>
                        <Popconfirm title="确定删除吗" onConfirm={store.delMember.bind(this, record)}>
                            <Button size="small" type="danger">删除</Button>
                        </Popconfirm>

                    </span>
                ),
            },
        ];

        return (
            <div>
                <FolderButtonSection
                    handleRefreshThisPage={this.handleSearch.bind(this)}
                    handleResetThisPageData={this.handleReset.bind(this)}

                    rightTools={
                        <Button type="primary" style={{ marginRight: "10px" }}
                            onClick={() => { this.changeShow('add', true, null) }}>
                            新增学生
                        </Button>
                    }
                    section={
                        <div>
                            <Form labelAlign="left" layout="inline" ref={this.formRef}>
                                <Row type="flex" justify="start" style={{ marginTop: "10px" }}>
                                    <Form.Item label="姓名" name='name'>
                                        <Input placeholder="请输入姓名" value={store.s_name} style={{ width: 200 }}
                                            onPressEnter={() => {
                                                store.handleGetStudent()
                                            }}
                                            onChange={(e) => {
                                                store.s_name = e.target.value

                                            }}
                                        />
                                    </Form.Item>
                                    <Form.Item label="专业" name='communityName'>
                                        <Input placeholder="请输入专业" value={store.major} style={{ width: 200 }}
                                            onPressEnter={() => {
                                                store.handleGetStudent()
                                            }}
                                            onChange={(e) => {
                                                store.major = e.target.value

                                            }}
                                        />
                                    </Form.Item>
                                    <Form.Item label="班级" name='communityName'>
                                        {/* <Input placeholder="请输入" value={store.major} style={{ width: 200 }}
                                            onPressEnter={() => {
                                                store.handleGetStudent()
                                            }}
                                            onChange={(e) => {
                                                store.major = e.target.value

                                            }}
                                        /> */}
                                    </Form.Item>
                                </Row>
                            </Form>

                        </div>
                    }
                />
                <Table
                    bordered={true}
                    pagination={{
                        current: store.studentCurrent,
                        pageSize: store.pageSize,
                        total: store.studentTotal,
                    }}
                    columns={columns}
                    style={{ marginTop: "10px", textAlign: 'center' }}
                    dataSource={Stores.studentData}
                // onChange={({ current }) => {
                //     this.handlePageNumber(current)
                // }}
                />
                {/* <GridMemberAdd />
                <GridMemberEdit /> */}
            </div>

        );
    }
}

export default Student;