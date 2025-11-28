import { sveltekit } from '@sveltejs/kit/vite';
import { defineConfig } from 'vite';
import mkcert from 'vite-plugin-mkcert';
import basicSsl from '@vitejs/plugin-basic-ssl';

export default defineConfig({
	plugins: [
	    sveltekit(),
	    basicSsl(),
	],
	server: {
	    https: true,
	    proxy: {},
	    allowedHosts: ["3.27.115.22.nip.io", "3.27.115.22"],
	    plugins: [sveltekit(), mkcert()]
	}
});
