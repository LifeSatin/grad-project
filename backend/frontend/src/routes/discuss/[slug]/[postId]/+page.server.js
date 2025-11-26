/** @type {import('./$types').PageLoad} */
export async function load({ fetch, params }) {
	const res = await fetch(`http://backend:8080/discuss/board/post?postId=${params.postId}`, {
                 headers: {
                 "Access-Control-Allow-Origin": "http://localhost:8080",
            }
        }
    );
    const post = await res.json();
    console.log(params.postId);
    console.log("load");
    console.log(post);
    return { post };
}

/** @satisfies {import('./$types').Actions} */
export const actions = {
    default: async ({cookies, request, params}) => {
        const formData = await request.formData();
        const token = cookies.get("token");
        console.log(formData);
        console.log(token);
        formData.append("authorToken", token);
        console.log(formData);
        const res = await fetch(`http://backend:8080/comments/write`, {
            method: "POST",
            headers: {
                "Access-Control-Allow-Origin": "http://backend:8080",
            },
            body: formData,
        });
        const item = await res.json();

        if (item.status === 500) {
            return -1;
        }
    }
}