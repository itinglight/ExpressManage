import axios from "axios"

export function get(url,params){
    return axios.get(url,{
        params
    });
}
export function post(url,data){
    return axios.post(url,data);
}

export function del(url){
    return axios.delete(url);

}
export function put(url,data){
    return axios.put(url,data);
}