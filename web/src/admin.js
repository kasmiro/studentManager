import  "babel-polyfill";
import React from 'react';
import ReactDOM from 'react-dom';
import zhCN from 'antd/lib/locale-provider/zh_CN';
import { ConfigProvider, Divider } from 'antd';
import moment from 'moment';
import 'moment/locale/zh-cn';
import 'nprogress/nprogress.css'
import 'antd-mobile/dist/antd-mobile.less'
import Stores from './store/Stores'

import 'braft-editor/dist/index.css'

moment.locale('zh-cn');

import '../style/less/adminSystem.less'
class App extends React.Component {
    render() {
        return (
            <ConfigProvider locale={zhCN}>
                <div style={{height:"100%",minWidth:1200}} {...Stores}>
                </div>
            </ConfigProvider>

        );
    }
}


ReactDOM.render(<App />, document.getElementById('app'));
