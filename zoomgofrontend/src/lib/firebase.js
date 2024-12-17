import { initializeApp } from "firebase/app";
import { getFirestore } from "firebase/firestore";
import { getStorage } from "firebase/storage";

const firebaseConfig = {
  apiKey: import.meta.env.VITE_API_KEY,
  authDomain: "zoomgochat.firebaseapp.com",
  projectId: "zoomgochat",
  storageBucket: "zoomgochat.appspot.com",
  messagingSenderId: "615924180575",
  appId: "1:615924180575:web:1d3824f4e4f1bfdfbe5dea"
};

const app = initializeApp(firebaseConfig);

export const db = getFirestore()
export const storage = getStorage()
