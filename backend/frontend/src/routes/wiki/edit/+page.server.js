/** @type {import('./$types').PageLoad} */
export async function load({ url }) {
    const res = await fetch(`http://localhost:8080/wiki?pageName=${url.searchParams.get('pageName')}`, {
                        headers: {
                            "Access-Control-Allow-Origin": "http://localhost:8080",
                        }
                    });
        const item = await res.json();
        return { pageExists: item.status !== 200, pageContent: item.content };
}

/** @satisfies {import('./$types').Actions} */

import { redirect } from '@sveltejs/kit';

export const actions = {
    default: async ({request, url}) => {
        const formData = await request.formData();
        formData.set("pageName", formData.get("pageName"));
        formData.set("content", formData.get("content"));
        console.log(formData);
        const res = await fetch(`http://localhost:8080/wiki`, {
            method: "PATCH",
            body: formData,
        });
        const item = await res.json();

        if (item.status === 500) {
            return -1;
        }

        if (item.status === 200) {
            throw redirect(303, `/wiki/${url.searchParams.get('pageName')}`);
        }
    }
}