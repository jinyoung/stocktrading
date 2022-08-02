<template>

    <v-data-table
        :headers="headers"
        :items="prices"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PricesView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "item", value: "item" },
                { text: "price", value: "price" },
            ],
            prices : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/prices'))

            temp.data._embedded.prices.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.prices = temp.data._embedded.prices;
        },
        methods: {
        }
    }
</script>

