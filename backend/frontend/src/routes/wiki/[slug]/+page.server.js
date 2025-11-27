/** @type {import('./$types').PageLoad} */
export async function load({ params }) {
    const res = await fetch(`http://3.27.115.22:8080/wiki?pageName=${params.slug}`);
    const item = await res.json();
    console.log(item);
    return { pageExists: item.status !== 200, pageContent: item.content, pageName: params.slug };
}

/** @satisfies {import('./$types').Actions} */

import { redirect } from '@sveltejs/kit';

export const actions = {
    default: async ({request, params}) => {
        const formData = await request.formData();
        formData.set("pageName", encodeURIComponent(formData.get("pageName")));
        console.log(formData);
        const res = await fetch(`http://3.27.115.22:8080/wiki`, {
            method: "POST",
            body: formData,
        });
        const item = await res.json();
        console.log(params.slug);

        if (item.status === 500) {
            return -1;
        }

        if (item.status === 200) {
            throw redirect(303, `/wiki/edit?pageName=${encodeURIComponent(params.slug)}`);
        }
    }
}