import Vue from "vue";
import Toast from "vue-toastification";
// Import the CSS or use your own!
import "vue-toastification/dist/index.css";

// you can also pass options, check options reference below
Vue.use(Toast, {
  position: "bottom-center",
});