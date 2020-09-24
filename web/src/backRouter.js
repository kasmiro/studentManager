import React from 'react'
import {Router, Route,Switch, hashHistory, Redirect, IndexRedirect, IndexRoute} from "react-router";
import {Provider} from "mobx-react";
import stores from "./adminStore";
import Loadable from 'react-loadable'
import {message} from "antd";
import NProgress from 'nprogress'

function Loading(props) {
    if (props.error) {
        return <div>网页走丢！</div>;
    } else if (props.pastDelay) {
        console.log('loading')
        return <div>{
            NProgress.start()
        }</div>;
    } else {
        NProgress.done

        return null;
    }
}
const Index = Loadable({
    loader:() => import('./modules/index'),
    loading:Loading,
    delay:800,
});
const RouterView =(
    <Router history={hashHistory} >
        <Route path="/index" component={Index} />
        <Redirect from="*" to="/index" />
    </Router>
);

const RouteConfig = () => {
    return <Provider {...stores}>{RouterView}</Provider>;
};

export default RouteConfig
