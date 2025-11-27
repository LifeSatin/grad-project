/** @type {import('./$types').PageLoad} */
export async function load({ fetch, params }) {
	const res = await fetch(`http://backend:8080/notice/post?postId=${params.slug}`, {
                    headers: {
                        "Access-Control-Allow-Origin": "http://backend:8080",
                    }
                });
    const item = await res.json();

    return { item };
}