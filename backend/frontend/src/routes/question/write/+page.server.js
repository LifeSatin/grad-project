/** @satisfies {import('./$types').Actions} */

import { redirect } from '@sveltejs/kit';

export const actions = {
    default: async ({cookies, request}) => {
        const formData = await request.formData();
        const token = cookies.get("token");
        let today = new Date();
        formData.append("time", today.toLocaleDateString());
        formData.append("authorToken", token);
        console.log(formData);
        const res = await fetch(`http://3.27.115.22:8080/question/write`, {
            method: "POST",
            body: formData
        });
        const item = await res.json();
        console.log(item);

        if (item.status === 500) {
            return -1;
        }

        if (item.status === 200) {
            throw redirect(303, `/question/${item.postId}`);
        }
    }
}