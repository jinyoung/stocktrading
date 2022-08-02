<template>

    <v-card outlined>
        <v-card-title>
            Asset # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Item" v-model="item.item" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Amount" v-model="item.amount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AccountId" v-model="item.accountId" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'AssetViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/assets/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

