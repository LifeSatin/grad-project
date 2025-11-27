import { sveltekit } from '@sveltejs/kit/vite';
import { defineConfig } from 'vite';

export default defineConfig({
	plugins: [sveltekit()],
	server: {
	    allowedHosts: ["3.27.115.22.nip.io"],
	}
});
