<template>

    <v-card style="width:450px;" outlined>
        <template slot="progress">
            <v-progress-linear
                    color="deep-purple"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

        <v-card-title v-if="value._links">
            Request # {{value._links.self.href.split("/")[value._links.self.href.split("/").length - 1]}}
        </v-card-title >
        <v-card-title v-else>
            Request
        </v-card-title >

        <v-card-text>
            <Number label="Price" v-model="value.price" :editMode="editMode"/>
            <String label="Item" v-model="value.item" :editMode="editMode"/>
            <String label="AccountId" v-model="value.accountId" :editMode="editMode"/>
            <String label="Status" v-model="value.status" :editMode="editMode"/>
            <Boolean label="Bid" v-model="value.bid" :editMode="editMode"/>
            <Number label="Quantity" v-model="value.quantity" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="save"
                    v-else
            >
                Save
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="editMode = false"
                    v-if="editMode && !isNew"
            >
                Cancel
            </v-btn>
        </v-card-actions>
        <v-card-actions>
            <v-spacer></v-spacer>                        
            <v-btn
                    v-if="!editMode"
                    color="deep-purple lighten-2"
                    text
                    @click="buy"
            >
                Buy
            </v-btn>
            <v-btn
                    v-if="!editMode"
                    color="deep-purple lighten-2"
                    text
                    @click="sell"
            >
                Sell
            </v-btn>
            <v-btn
                    v-if="!editMode"
                    color="deep-purple lighten-2"
                    text
                    @click="test"
            >
                Test
            </v-btn>
            <v-btn
                    v-if="!editMode"
                    color="deep-purple lighten-2"
                    text
                    @click="option"
            >
                Option
            </v-btn>
            <v-btn
                    v-if="!editMode"
                    color="deep-purple lighten-2"
                    text
                    @click="option2"
            >
                Option2
            </v-btn>
            <v-btn
                    v-if="!editMode"
                    color="deep-purple lighten-2"
                    text
                    @click="option3"
            >
                Option3
            </v-btn>
        </v-card-actions>

        <v-snackbar
                v-model="snackbar.status"
                :top="true"
                :timeout="snackbar.timeout"
                color="error"
        >
            {{ snackbar.text }}
            <v-btn dark text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
    </v-card>

</template>

<script>
    const axios = require('axios').default;


    export default {
        name: 'Request',
        components:{
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
        },
        data: () => ({
            snackbar: {
                status: false,
                timeout: 5000,
                text: ''
            },
        }),
        created(){
        },
        methods: {
            selectFile(){
                if(this.editMode == false) {
                    return false;
                }
                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.imageUrl = result;
                        me.value.photo = result;
                        
                    };
                    reader.readAsDataURL( file );
                };
            },
            edit() {
                this.editMode = true;
            },
            async save(){
                try {
                    var temp = null;

                    if(!this.offline) {
                        if(this.isNew) {
                            temp = await axios.post(axios.fixUrl('/requests'), this.value)
                        } else {
                            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
                        }
                    }

                    if(this.value!=null) {
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    } else {
                        this.value = temp.data;
                    }

                    this.editMode = false;
                    this.$emit('input', this.value);

                    if (this.isNew) {
                        this.$emit('add', this.value);
                    } else {
                        this.$emit('edit', this.value);
                    }

                    location.reload()

                } catch(e) {
                    this.snackbar.status = true
                    this.snackbar.text = e
                }
                
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links.self.href))
                    }

                    this.editMode = false;
                    this.isDeleted = true;

                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);

                } catch(e) {
                    this.snackbar.status = true
                    this.snackbar.text = e
                }
            },
            change(){
                this.$emit('input', this.value);
            },
            async test() {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links.test.href))
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                } catch(e) {
                    this.snackbar.status = true
                    this.snackbar.text = e
                }
            },
            async option() {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links.option.href))
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                } catch(e) {
                    this.snackbar.status = true
                    this.snackbar.text = e
                }
            },
            async option2() {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links.option2.href))
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                } catch(e) {
                    this.snackbar.status = true
                    this.snackbar.text = e
                }
            },
            async option3() {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links.option3.href))
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                } catch(e) {
                    this.snackbar.status = true
                    this.snackbar.text = e
                }
            },
        },
    }
</script>

