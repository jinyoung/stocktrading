
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RequestManager from "./components/listers/RequestCards"
import RequestDetail from "./components/listers/RequestDetail"

import TradeManager from "./components/listers/TradeCards"
import TradeDetail from "./components/listers/TradeDetail"
import BidManager from "./components/listers/BidCards"
import BidDetail from "./components/listers/BidDetail"
import AskManager from "./components/listers/AskCards"
import AskDetail from "./components/listers/AskDetail"


import PricesView from "./components/PricesView"
import PricesViewDetail from "./components/PricesViewDetail"

import AssetView from "./components/AssetView"
import AssetViewDetail from "./components/AssetViewDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/requests',
                name: 'RequestManager',
                component: RequestManager
            },
            {
                path: '/requests/:id',
                name: 'RequestDetail',
                component: RequestDetail
            },

            {
                path: '/trades',
                name: 'TradeManager',
                component: TradeManager
            },
            {
                path: '/trades/:id',
                name: 'TradeDetail',
                component: TradeDetail
            },
            {
                path: '/bids',
                name: 'BidManager',
                component: BidManager
            },
            {
                path: '/bids/:id',
                name: 'BidDetail',
                component: BidDetail
            },
            {
                path: '/asks',
                name: 'AskManager',
                component: AskManager
            },
            {
                path: '/asks/:id',
                name: 'AskDetail',
                component: AskDetail
            },


            {
                path: '/prices',
                name: 'PricesView',
                component: PricesView
            },
            {
                path: '/prices/:id',
                name: 'PricesViewDetail',
                component: PricesViewDetail
            },

            {
                path: '/assets',
                name: 'AssetView',
                component: AssetView
            },
            {
                path: '/assets/:id',
                name: 'AssetViewDetail',
                component: AssetViewDetail
            },



    ]
})
