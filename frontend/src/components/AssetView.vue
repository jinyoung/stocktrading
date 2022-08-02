<template>

    <v-data-table
        :headers="headers"
        :items="asset"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'AssetView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "item", value: "item" },
                { text: "amount", value: "amount" },
                { text: "accountId", value: "accountId" },
            ],
            asset : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/assets'))

            temp.data._embedded.assets.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.asset = temp.data._embedded.assets;
        },
        methods: {
        }
    }
</script>

